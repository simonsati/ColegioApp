package com.colegio.reportes;

import com.colegio.modelo.Colegio;
import com.colegio.modelo.Estudiante;
import com.colegio.modelo.Profesor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Genera los reportes de texto de la aplicación.
 *
 * Relación de DEPENDENCIA con Colegio: no lo guarda como atributo, solo lo
 * recibe como parámetro en cada método de reporte.
 */
public class GeneradorReportes {

    private static final Locale CO = Locale.forLanguageTag("es-CO");
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /** Ancho (en caracteres) de las líneas separadoras del reporte. */
    private int anchoLinea = 118;

    // ---------------------------------------------------------------- get / set
    public int getAnchoLinea() {
        return anchoLinea;
    }

    public void setAnchoLinea(int anchoLinea) {
        this.anchoLinea = anchoLinea;
    }

    // ---------------------------------------------------------------- reportes
    /** REPORTE 1: lista de los estudiantes registrados. */
    public String reporteEstudiantes(Colegio colegio) {
        StringBuilder sb = new StringBuilder();
        encabezado(sb, "REPORTE DE ESTUDIANTES", colegio);
        List<Estudiante> estudiantes = colegio.getEstudiantes();
        if (estudiantes.isEmpty()) {
            sb.append("No hay estudiantes registrados.\n");
            return sb.toString();
        }
        sb.append(String.format("%-4s %-10s %-28s %5s  %-10s %-12s %-26s%n",
                "#", "Código", "Nombre", "Edad", "Grado", "Teléfono", "Acudiente"));
        sb.append(linea('-'));
        int i = 1;
        for (Estudiante e : estudiantes) {
            sb.append(String.format("%-4d %-10s %-28s %5d  %-10s %-12s %-26s%n",
                    i++, e.getCodigo(), recortar(e.getNombre(), 28), e.calcularEdad(),
                    e.getGrado(), e.getTelefono(), recortar(e.getAcudiente(), 26)));
        }
        sb.append(linea('-'));
        sb.append("Total de estudiantes: ").append(estudiantes.size()).append('\n');
        return sb.toString();
    }

    /**
     * REPORTE 2: profesores ordenados por salario total (de mayor a menor),
     * con sus prestaciones sociales y los totales que debe cubrir el colegio.
     */
    public String reporteProfesoresPorSalario(Colegio colegio) {
        StringBuilder sb = new StringBuilder();
        encabezado(sb, "REPORTE DE PROFESORES POR SALARIO (MAYOR A MENOR)", colegio);
        List<Profesor> profesores = colegio.getProfesoresOrdenadosPorSalario();
        if (profesores.isEmpty()) {
            sb.append("No hay profesores registrados.\n");
            return sb.toString();
        }
        sb.append(String.format("%-4s %-12s %-24s %-18s %5s %11s %14s %14s %14s%n",
                "#", "Cédula", "Nombre", "Área", "Horas", "Valor hora",
                "Salario total", "Prestaciones", "Costo total"));
        sb.append(linea('-'));
        int i = 1;
        for (Profesor p : profesores) {
            sb.append(String.format("%-4d %-12s %-24s %-18s %5d %11s %14s %14s %14s%n",
                    i++, p.getCedula(), recortar(p.getNombre(), 24), recortar(p.getArea(), 18),
                    p.getHorasDictadas(), moneda(p.getSalarioHora()),
                    moneda(p.calcularPagoMensual()), moneda(p.calcularPrestaciones()),
                    moneda(p.calcularCostoTotal())));
        }
        sb.append(linea('-'));
        double nomina = colegio.calcularTotalNomina();
        double prestaciones = colegio.calcularTotalPrestaciones();
        sb.append(String.format("Total de profesores:                %d%n", profesores.size()));
        sb.append(String.format("Total salarios (nómina):            %s%n", moneda(nomina)));
        sb.append(String.format("TOTAL PRESTACIONES SOCIALES (19%%):  %s%n", moneda(prestaciones)));
        sb.append(String.format("Costo total para el colegio:        %s%n", moneda(nomina + prestaciones)));
        sb.append(linea('='));
        sb.append("Salario total = salario por hora x horas dictadas + 30% por preparación de clase.\n");
        return sb.toString();
    }

    // ---------------------------------------------------------------- utilidades
    private void encabezado(StringBuilder sb, String titulo, Colegio colegio) {
        sb.append(linea('='));
        sb.append(titulo).append(" - ").append(colegio.getNombre()).append('\n');
        sb.append("Generado: ").append(LocalDateTime.now().format(FORMATO_FECHA_HORA)).append('\n');
        sb.append(linea('='));
    }

    private String linea(char c) {
        return String.valueOf(c).repeat(anchoLinea) + "\n";
    }

    private static String recortar(String texto, int max) {
        if (texto == null) {
            return "";
        }
        return texto.length() <= max ? texto : texto.substring(0, max - 1) + "…";
    }

    static String moneda(double valor) {
        return String.format(CO, "$%,.0f", valor);
    }
}
