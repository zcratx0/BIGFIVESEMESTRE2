package utils;

import java.io.FileWriter;
import java.io.IOException;
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
		
        String[][] materias = {
           		{"UNIDAD CURRICULAR", "Créd", "Dur", "Tip", "Año", "Conv", "Calificación"}
         };
        
        
        
        float margin = 50;
        float yStart = pagina.getMediaBox().getHeight() - margin;
        float tableWidth = pagina.getMediaBox().getWidth() - 2 * margin;
        float yPosition = yStart - 150;
        float bottomMargin = 70;
        
        int rows = materias.length;
        int cols = materias[0].length;
        float rowHeight = 20;
        float tableRowStart = yPosition;

        float cellMargin = 10f;
        float cellWidth = (tableWidth - 2 * cellMargin) / (float) cols;
        float[] cellHeight = { 20f, 20f };

        
        // Add content to table cells
        float textY = yPosition - 15;
        float textX = margin + cellMargin;
        float cellTextY = textY - 5;

        
        
        
       
        /* 	OLD
        for (int i = 0; i < rows; i++) {
            textY -= rowHeight;
            for (int j = 0; j < cols; j++) {
                String text = materias[i][j];
                float cellTextWidth = PDType1Font.TIMES_ROMAN.getStringWidth(text) / 1000 * 12;
                writer.setFont(PDType1Font.TIMES_ROMAN, 12);
                if (i == 0) {
                	writer.setFont(PDType1Font.TIMES_BOLD, 24);
                }
                float cellWidthMargin = textX + (cellWidth - cellTextWidth) / 2;

                writer.beginText();
                writer.setFont(PDType1Font.TIMES_ROMAN, 12);
                writer.newLineAtOffset(cellWidthMargin, textY);
                writer.showText(text);
                writer.endText();
                
                textX += cellWidth;
            }
            textX = margin + cellMargin;
        }
        
        */
        for (int i = 0; i < escoList.size(); i++) {
            textY -= rowHeight;
            Escolaridad eso = escoList.get(i);
            try {
            	write(writer, eso.getUnidadCurricular(), textX, textY, cellWidth);
            	textX += cellWidth;
            	
            	write(writer, eso.getCredito(), textX, textY, cellWidth);
            	textX += cellWidth;
            
            	write(writer, eso.getDuracion(), textX, textY, cellWidth);
            	textX += cellWidth;
            	
            	write(writer, eso.getTipo(), textX, textY, cellWidth);
            	textX += cellWidth;

            	write(writer, eso.getAnio(), textX, textY, cellWidth);
            	textX += cellWidth;

            	write(writer, eso.getConv(), textX, textY, cellWidth);
            	textX += cellWidth;
            
            	write(writer, eso.getCalificacion(), textX, textY, cellWidth);
            	textX += cellWidth;
            	
            } catch (Exception e) {
            	System.out.println(e.getMessage());
			}
            

            textX = margin + cellMargin;            //	FIN DE LA ESCOLARIDAD
        }
        
        
        
		writer.close();	//	Cerramos el editor de texto
		
		documento.save(path+".pdf");
		documento.close();
	}
	
	public void write(PDPageContentStream writer, String text, float textX, float textY, float cellWidth) throws IOException {
		float cellTextWidth = PDType1Font.TIMES_ROMAN.getStringWidth(text) / 1000 * 12;
        float cellWidthMargin = textX + (cellWidth - cellTextWidth) / 2;
        writer.beginText();
        
        writer.setFont(PDType1Font.TIMES_ROMAN, 12);
        writer.newLineAtOffset(cellWidthMargin, textY);
        writer.showText(text);      
        
        writer.endText();
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
