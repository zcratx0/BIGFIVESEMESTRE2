package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.bigfive.entities.Estudiante;

public class TBFDownload {
	private static TBFDownload instance = new TBFDownload();
	public TBFDownload() {
		
	}
	
	public void Download(String name) {
		try {
			FileWriter file = new FileWriter(name);
			file.write("Escolaridad");
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void generarPDF(String path, Estudiante estudiante, List<Escolaridad> escoList) throws IOException {
		PDDocument documento = new PDDocument();
		PDPage pagina = new PDPage();
		documento.addPage(pagina);
		//	INFORMACION DEL PDF
		PDDocumentInformation informacion = new PDDocumentInformation();
		informacion.setAuthor("UTEC"); // Guardamos el nombre del author
		informacion.setCreationDate(new GregorianCalendar());	//	Guardamos la fecha donde lo creamos.
		informacion.setTitle("ESCOLARIDAD ");	// Guardamos el nombre del titulo

		documento.setDocumentInformation(informacion);
		
		PDPageContentStream writer = new PDPageContentStream(documento, pagina);	//	Abrimos el editor de texto.
		writer.beginText();
		writer.setFont(PDType1Font.TIMES_ROMAN, 16);	//	Seleccionamos el tipo de letra.
		writer.setLeading(14.5f);		
		writer.newLineAtOffset(25, 725);
		
		//	DATOS DEL ESTUDIANTE
		String espacio = "        ";
		
		writer.setFont(PDType1Font.TIMES_BOLD, 24);
		writer.showText("DATOS DEL ESTUDIANTE");
		
		writer.setFont(PDType1Font.TIMES_ROMAN, 16);
		writer.newLine();
		writer.newLine();
		
		writer.showText("Nombre y Apellido: " + espacio + estudiante.getUsuario().getNombre() + ' ' + estudiante.getUsuario().getApellido());
		writer.newLine();
		writer.showText("Documento de identidad: "+ espacio + estudiante.getUsuario().getDocumento());
		writer.newLine();
		writer.showText("Año de Ingreso: " + espacio + estudiante.getGeneracion());
		writer.newLine();
		writer.showText("Sede: " + espacio + estudiante.getUsuario().getItr().getNombre());
		
		writer.newLine();
		writer.newLine();
		writer.newLine();
        writer.endText();
		
        
        //	Cargar Datos de la unidad
        
        ArrayList<ArrayList<String>> materias = new ArrayList<>();	//	Almacenarlo en una lista para trabajar de forma más simple
        
        String[] materiasTitle = {"Unidad Curricular", "Créd", "Dur", "Tip", "Año", "Conv", "Calificación"};	//	Cargar lo que será los nombres de las columnas.
        
        materias.add(new ArrayList<String>());
        for (int i = 0; i < materiasTitle.length; i++) {
        	materias.get(0).add(materiasTitle[i]);
        }
        
        
        System.out.println("La lista de escolaridad tiene el tamaño de " + escoList.size());
        
        escoList.forEach(esco -> {
        	//TODO	Quitar los comentario.
        	System.out.println("Cargando " + escoList.indexOf(esco) + "- " + esco.getUnidadCurricular());
        	ArrayList<String> escolaridad = new ArrayList<>();
        	try {
        		escolaridad.add(esco.getUnidadCurricular()); 
        		escolaridad.add(esco.getCredito());
        		escolaridad.add(esco.getDuracion());
        		escolaridad.add(esco.getTipo());
        		escolaridad.add(esco.getAnio());
        		escolaridad.add(esco.getConv());
        		escolaridad.add(esco.getCalificacion());
        		
            	materias.add(escolaridad);
        	} catch (Exception e) {
				System.out.println("Tamaño de la lista: " + materias.size() + "\n" + e.getMessage());
			}
        });
        
        float margin = 50;
        float yStart = pagina.getMediaBox().getHeight() - margin;
        float tableWidth = pagina.getMediaBox().getWidth() - 2 * margin;
        float yPosition = yStart - 150;
        float bottomMargin = 70;
        
        int rows = materias.size();
        int cols = materias.get(0).size();
        float rowHeight = 20;
        float tableRowStart = yPosition;

        float cellMargin = 10f;
        float cellWidth = (tableWidth - 2 * cellMargin) / (float) cols;
        float[] cellHeight = { 20f, 20f };

        
        // Add content to table cells
        float textY = yPosition - 15;
        float textX = margin + cellMargin;
        float cellTextY = textY - 5;
 
       
        for (int i = 0; i < rows; i++) {
            textY -= rowHeight;
            for (int j = 0; j < cols; j++) {
                String text = materias.get(i).get(j);
                float cellTextWidth = (text == null ? 12 : PDType1Font.TIMES_ROMAN.getStringWidth(text)) / 1000 * 12;
                writer.setFont(PDType1Font.TIMES_ROMAN, 12);
                if (i == 0) {
                	writer.setFont(PDType1Font.TIMES_BOLD, 24);
                }
                float cellWidthMargin = textX + (cellWidth - cellTextWidth) / 2;
                writer.beginText();
                writer.setFont(PDType1Font.TIMES_ROMAN, 12);
                writer.newLineAtOffset(cellWidthMargin, textY);
                if (text == null) writer.showText("null");
                else writer.showText(text);
                writer.endText();
                textX += cellWidth;
            }
            textX = margin + cellMargin;
        }
        
        
        
		writer.close();	//	Cerramos el editor de texto
		if (!path.substring(path.lastIndexOf(".")+1).equalsIgnoreCase("pdf")) path += ".pdf";
		documento.save(path);
		documento.close();
	}
	
	
	/**
	 * @return the instance
	 */
	public static TBFDownload getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(TBFDownload instance) {
		TBFDownload.instance = instance;
	}
}
