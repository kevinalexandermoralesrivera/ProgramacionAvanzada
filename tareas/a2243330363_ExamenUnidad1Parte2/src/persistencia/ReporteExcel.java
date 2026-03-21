package persistencia;

import modelo.Producto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class ReporteExcel {

    // REPORTE GENERAL
    public void generarReporteGeneral(ArrayList<Producto> lista){

        try{

            Workbook libro = new XSSFWorkbook();
            Sheet hoja = libro.createSheet("Productos");

            Row header = hoja.createRow(0);

            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Código");
            header.createCell(2).setCellValue("Nombre");
            header.createCell(3).setCellValue("Categoría");
            header.createCell(4).setCellValue("Precio");
            header.createCell(5).setCellValue("Stock");

            int fila = 1;

            for(Producto p : lista){

                Row row = hoja.createRow(fila++);

                row.createCell(0).setCellValue(p.getId());
                row.createCell(1).setCellValue(p.getCodigo());
                row.createCell(2).setCellValue(p.getNombre());
                row.createCell(3).setCellValue(p.getCategoria());
                row.createCell(4).setCellValue(p.getPrecio());
                row.createCell(5).setCellValue(p.getStock());
            }

            FileOutputStream file = new FileOutputStream("reporte_general.xlsx");
            libro.write(file);
            file.close();

            System.out.println("Reporte general generado");

        }catch(Exception e){
            System.out.println("Error al generar Excel");
        }
    }

    // REPORTE POR CATEGORÍA
    public void generarPorCategoria(ArrayList<Producto> lista, String categoria){

        try{

            Workbook libro = new XSSFWorkbook();
            Sheet hoja = libro.createSheet(categoria);

            Row header = hoja.createRow(0);

            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Nombre");
            header.createCell(2).setCellValue("Precio");
            header.createCell(3).setCellValue("Stock");

            int fila = 1;

            for(Producto p : lista){

                if(p.getCategoria().equals(categoria)){

                    Row row = hoja.createRow(fila++);

                    row.createCell(0).setCellValue(p.getId());
                    row.createCell(1).setCellValue(p.getNombre());
                    row.createCell(2).setCellValue(p.getPrecio());
                    row.createCell(3).setCellValue(p.getStock());
                }
            }

            FileOutputStream file = new FileOutputStream("reporte_" + categoria + ".xlsx");
            libro.write(file);
            file.close();

            System.out.println("Reporte por categoría generado");

        }catch(Exception e){
            System.out.println("Error Excel categoría");
        }
    }
}