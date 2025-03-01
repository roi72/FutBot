package Clases;

import java.util.ArrayList;



public class Filter {

    public static ArrayList<Result> filtrarInfo(String elementosAFiltrar, String nombreEquipo1, String nombreEquipo2,
                                                String partido, int ronda) {

        int datosEquipo1[] = new int[15];
        int datosEquipo2[] = new int[15];

        int posesionEquipo1, posesionEquipo2;
        int golesEquipo1, golesEquipo2;
        int cornersEquipo1, cornersEquipo2;
        int fuerasDeJuegoEquipo1, fuerasDeJuegoEquipo2;
        int pasesEnProfundidadEquipo1, pasesEnProfundidadEquipo2;
        int ocasionesEquipo1, ocasionesEquipo2;
        int tirosTotalesEquipo1, tirosTotalesEquipo2;
        int tirosPuerta1, tirosPuerta2;
        int tirosPalo1, tirosPalo2;
        int tirosFuera1, tirosFuera2;
        int tirosBloqueados1, tirosBloqueados2;
        int entradas1, entradas2;
        int faltas1, faltas2;
        int tarjetasAmarillas1, tarjetasAmarillas2;

        String posesionDatos = elementosAFiltrar.split("Posesión de balón: ")[1].split(",")[0].replace("%", "");
        String posesionValores[] = posesionDatos.split("-");
        posesionEquipo1 = Integer.parseInt(posesionValores[0].trim());
        posesionEquipo2 = Integer.parseInt(posesionValores[1].trim());

        String golesDatos = elementosAFiltrar.split("Resultado: ")[1].split(",")[0];
        String[] golesValores = golesDatos.split("-");
        golesEquipo1 = Integer.parseInt(golesValores[0].trim());
        golesEquipo2 = Integer.parseInt(golesValores[1].trim());

        String cornersDatos = elementosAFiltrar.split("Saques de esquina: ")[1].split(",")[0];
        String[] cornersValores = cornersDatos.split("-");
        cornersEquipo1 = Integer.parseInt(cornersValores[0].trim());
        cornersEquipo2 = Integer.parseInt(cornersValores[1].trim());

        if (elementosAFiltrar.contains("Fueras de juego: ")) {
            String fuerasDeJuegoDatos = elementosAFiltrar.split("Fueras de juego: ")[1].split(",")[0];
            String[] fuerasDeJuegoValores = fuerasDeJuegoDatos.split("-");
            fuerasDeJuegoEquipo1 = Integer.parseInt(fuerasDeJuegoValores[0].trim());
            fuerasDeJuegoEquipo2 = Integer.parseInt(fuerasDeJuegoValores[1].trim());
        } else {
            fuerasDeJuegoEquipo1 = 0;
            fuerasDeJuegoEquipo2 = 0;
            datosEquipo1[4] = fuerasDeJuegoEquipo1;
            datosEquipo2[4] = fuerasDeJuegoEquipo2;
        }

        if (elementosAFiltrar.contains("Pases en profundidad: ")) {
            String pasesEnProfundidad = elementosAFiltrar.split("Pases en profundidad: ")[1].split(",")[0];
            String[] pasesEnProfundidadValores = pasesEnProfundidad.split("-");
            pasesEnProfundidadEquipo1 = Integer.parseInt(pasesEnProfundidadValores[0].trim());
            pasesEnProfundidadEquipo2 = Integer.parseInt(pasesEnProfundidadValores[1].trim());
        } else {
            pasesEnProfundidadEquipo1 = 0;
            pasesEnProfundidadEquipo2 = 0;
            datosEquipo1[5] = pasesEnProfundidadEquipo1;
            datosEquipo2[5] = pasesEnProfundidadEquipo2;
        }

        if (elementosAFiltrar.contains("Ocasiones claras: ")) {
            String ocasionesDatos = elementosAFiltrar.split("Ocasiones claras: ")[1].split(",")[0];
            String[] ocasionesValores = ocasionesDatos.split("-");
            ocasionesEquipo1 = Integer.parseInt(ocasionesValores[0].trim());
            ocasionesEquipo2 = Integer.parseInt(ocasionesValores[1].trim());
        } else {
            ocasionesEquipo1 = 0;
            ocasionesEquipo2 = 0;
            datosEquipo1[6] = ocasionesEquipo1;
            datosEquipo2[6] = ocasionesEquipo2;
        }

        if (elementosAFiltrar.contains("Ocasiones claras: ")) {
            String tirosTotalesDatos = elementosAFiltrar.split("Tiros totales: ")[1].split(",")[0];
            String[] tirosTotalesValores = tirosTotalesDatos.split("-");
            tirosTotalesEquipo1 = Integer.parseInt(tirosTotalesValores[0].trim());
            tirosTotalesEquipo2 = Integer.parseInt(tirosTotalesValores[1].trim());
        } else {
            tirosTotalesEquipo1 = 0;
            tirosTotalesEquipo2 = 0;
            datosEquipo1[7] = tirosTotalesEquipo1;
            datosEquipo2[7] = tirosTotalesEquipo2;
        }

        if (elementosAFiltrar.contains("Tiros a puerta: ")) {
            String tirosPuertaDatos = elementosAFiltrar.split("Tiros a puerta: ")[1].split(",")[0];
            String[] tirosPuertaValores = tirosPuertaDatos.split("-");
            tirosPuerta1 = Integer.parseInt(tirosPuertaValores[0].trim());
            tirosPuerta2 = Integer.parseInt(tirosPuertaValores[1].trim());
        } else {
            tirosPuerta1 = 0;
            tirosPuerta2 = 0;
            datosEquipo1[8] = tirosPuerta1;
            datosEquipo2[8] = tirosPuerta2;
        }

        if (elementosAFiltrar.contains("Tiros al palo: ")) {
            String tirosPaloDatos = elementosAFiltrar.split("Tiros al palo: ")[1].split(",")[0];
            String[] tirosPaloValores = tirosPaloDatos.split("-");
            tirosPalo1 = Integer.parseInt(tirosPaloValores[0].trim());
            tirosPalo2 = Integer.parseInt(tirosPaloValores[1].trim());
        } else {
            tirosPalo1 = 0;
            tirosPalo2 = 0;
            datosEquipo1[9] = tirosPalo1;
            datosEquipo2[9] = tirosPalo2;
        }

        if (elementosAFiltrar.contains("Tiros fuera: ")) {
            String tirosFueraDatos = elementosAFiltrar.split("Tiros fuera: ")[1].split(",")[0];
            String[] tirosFueraValores = tirosFueraDatos.split("-");
            tirosFuera1 = Integer.parseInt(tirosFueraValores[0].trim());
            tirosFuera2 = Integer.parseInt(tirosFueraValores[1].trim());

        } else {
            tirosFuera1 = 0;
            tirosFuera2 = 0;
            datosEquipo1[10] = tirosFuera1;
            datosEquipo2[10] = tirosFuera2;
        }

        if (elementosAFiltrar.contains("Tiros bloqueados: ")) {
            String tirosBloqueadosDatos = elementosAFiltrar.split("Tiros bloqueados: ")[1].split(",")[0];
            String[] tirosBloqueadosValores = tirosBloqueadosDatos.split("-");
            tirosBloqueados1 = Integer.parseInt(tirosBloqueadosValores[0].trim());
            tirosBloqueados2 = Integer.parseInt(tirosBloqueadosValores[1].trim());

        } else {
            tirosBloqueados1 = 0;
            tirosBloqueados2 = 0;
            datosEquipo1[11] = tirosBloqueados1;
            datosEquipo2[11] = tirosBloqueados2;
        }

        if (elementosAFiltrar.contains("Total de entradas: ")) {
            String entradasDatos = elementosAFiltrar.split("Total de entradas: ")[1].split(",")[0];
            String[] entradasValores = entradasDatos.split("-");
            entradas1 = Integer.parseInt(entradasValores[0].trim());
            entradas2 = Integer.parseInt(entradasValores[1].trim());
        } else {
            entradas1 = 0;
            entradas2 = 0;
            datosEquipo1[12] = entradas1;
            datosEquipo2[12] = entradas2;
        }

        if (elementosAFiltrar.contains("Faltas: ")) {
            String faltasDatos = elementosAFiltrar.split("Faltas: ")[1].split(",")[0];
            String[] faltasValores = faltasDatos.split("-");
            faltas1 = Integer.parseInt(faltasValores[0].trim());
            faltas2 = Integer.parseInt(faltasValores[1].trim());
        } else {
            faltas1 = 0;
            faltas2 = 0;
            datosEquipo1[12] = faltas1;
            datosEquipo2[12] = faltas2;
        }

        if (elementosAFiltrar.contains("Tarjetas amarillas: ")) {
            String tarjetasAmarillasDatos = elementosAFiltrar.split("Tarjetas amarillas: ")[1].split(",")[0];
            String[] tarjetasAmarillasValores = tarjetasAmarillasDatos.split("-");
            tarjetasAmarillas1 = Integer.parseInt(tarjetasAmarillasValores[0].trim());
            tarjetasAmarillas2 = Integer.parseInt(tarjetasAmarillasValores[1].trim());
        } else {
            tarjetasAmarillas1 = 0;
            tarjetasAmarillas2 = 0;
            datosEquipo1[14] = tarjetasAmarillas1;
            datosEquipo2[14] = tarjetasAmarillas2;
        }

        datosEquipo1[0] = ronda; // Ronda
        datosEquipo1[1] = posesionEquipo1; // Posesión
        datosEquipo1[2] = golesEquipo1; // Goles
        datosEquipo1[3] = cornersEquipo1; // Corners
        datosEquipo1[4] = fuerasDeJuegoEquipo1; // Fueras de juego
        datosEquipo1[5] = pasesEnProfundidadEquipo1; // Pases en profundidad
        datosEquipo1[6] = ocasionesEquipo1;
        datosEquipo1[7] = tirosTotalesEquipo1;
        datosEquipo1[8] = tirosPuerta1;
        datosEquipo1[9] = tirosPalo1;
        datosEquipo1[10] = tirosFuera1;
        datosEquipo1[11] = tirosBloqueados1;
        datosEquipo1[12] = entradas1;
        datosEquipo1[13] = faltas1;
        datosEquipo1[14] = tarjetasAmarillas1;

        datosEquipo2[0] = ronda; // Ronda
        datosEquipo2[1] = posesionEquipo2; // Posesión
        datosEquipo2[2] = golesEquipo2; // Goles
        datosEquipo2[3] = cornersEquipo2; // Corners
        datosEquipo2[4] = fuerasDeJuegoEquipo2; // Fueras de juego
        datosEquipo2[5] = pasesEnProfundidadEquipo2; // Pases en profundidad
        datosEquipo1[6] = ocasionesEquipo2;
        datosEquipo1[7] = tirosTotalesEquipo2;
        datosEquipo1[8] = tirosPuerta2;
        datosEquipo1[9] = tirosPalo2;
        datosEquipo1[10] = tirosFuera2;
        datosEquipo1[11] = tirosBloqueados2;
        datosEquipo1[12] = entradas2;
        datosEquipo1[13] = faltas2;
        datosEquipo1[14] = tarjetasAmarillas2;

        ArrayList<Result> listaEquipos = new ArrayList<>();

        Result resultado1 = new Result(nombreEquipo1, partido, ronda, posesionEquipo1, golesEquipo1,
                cornersEquipo1, fuerasDeJuegoEquipo1, pasesEnProfundidadEquipo1, ocasionesEquipo1, tirosTotalesEquipo1,
                tirosPuerta1, tirosPalo1, tirosFuera1, tirosBloqueados1, entradas1, faltas1, tarjetasAmarillas1);
        Result resultado2 = new Result(nombreEquipo2, partido, ronda, posesionEquipo2, golesEquipo2,
                cornersEquipo2, fuerasDeJuegoEquipo2, pasesEnProfundidadEquipo2, ocasionesEquipo2, tirosTotalesEquipo2,
                tirosPuerta2, tirosPalo2, tirosFuera2, tirosBloqueados2, entradas2, faltas2, tarjetasAmarillas2);

        listaEquipos.add(resultado1);
        listaEquipos.add(resultado2);

        return listaEquipos;
    }

}
