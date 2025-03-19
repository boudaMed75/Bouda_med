package bouda.med.company.services.File;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Service
public class InvoicePdfService {

    public void generateInvoice(HttpServletResponse response) {
        try {
            // Configuration de la réponse HTTP
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"facture.pdf\"");
            OutputStream out = response.getOutputStream();

            // Création du document PDF
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();

            // Ajouter l'en-tête avec le logo et les coordonnées de l'entreprise
            addHeader(document, writer);

            // Ajouter le titre de la facture
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLUE);
            Paragraph title = new Paragraph("Facture", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Informations du vendeur
            Paragraph sellerInfo = new Paragraph("Vendeur :\n Mon Entreprise\n22, Avenue Voltaire\n13000 Marseille\n\n");
            document.add(sellerInfo);

            // Informations du client
            Paragraph clientInfo = new Paragraph("Client :\nMichel Acheteur\n31, rue de la Forêt\n13100 Aix-en-Provence\n\n");
            document.add(clientInfo);

            // Tableau pour les détails de la facture
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3, 2, 2, 2, 2});

            // En-têtes de tableau
            String[] headers = {"Description", "Quantité", "Unité", "Prix Unitaire HT", "Total TTC"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
            }

            // Ajouter des données de la facture
            table.addCell("Main-d'œuvre");
            table.addCell("5");
            table.addCell("h");
            table.addCell("60,00 €");
            table.addCell("360,00 €");

            table.addCell("Produit");
            table.addCell("10");
            table.addCell("pcs");
            table.addCell("105,00 €");
            table.addCell("1 280,00 €");

            document.add(table);

            // Total HT, TVA, et TTC
            document.add(new Paragraph("\nTotal HT : 1 350,00 €"));
            document.add(new Paragraph("Total TVA : 270,00 €"));
            document.add(new Paragraph("Total TTC : 1 620,00 €"));

            document.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter l'en-tête avec un logo et des coordonnées

    private void addHeader(Document document, PdfWriter writer) throws DocumentException {
        PdfPTable headerTable = new PdfPTable(2);  // Create a table with 3 columns
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{1, 1});  // Adjust column widths as needed
    
        // Add the logo
        try {
            ClassPathResource resource = new ClassPathResource("Images/Logo.jpeg");
            Image logo = Image.getInstance(resource.getURL());
            logo.scaleToFit(70, 70);
    
            PdfPCell logoCell = new PdfPCell(logo, false);
            logoCell.setBorder(Rectangle.NO_BORDER);
            logoCell.setHorizontalAlignment(Element.ALIGN_LEFT);  // Align logo to the left
            logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerTable.addCell(logoCell);
        } catch (Exception e) {
            e.printStackTrace();
            PdfPCell emptyLogoCell = new PdfPCell(new Phrase(""));
            emptyLogoCell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(emptyLogoCell);
        }
    
        // Add the title "Facture"
        
    
        // Add company information
        PdfPCell companyInfoCell = new PdfPCell();
        companyInfoCell.setBorder(Rectangle.NO_BORDER);
        companyInfoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        companyInfoCell.setHorizontalAlignment(Element.ALIGN_RIGHT);  // Align text to the right
    
        // Company information content
        Paragraph companyInfo = new Paragraph();
        companyInfo.add(new Chunk("Mon Entreprise\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
        companyInfo.add(new Chunk("22, Avenue Voltaire\n", FontFactory.getFont(FontFactory.HELVETICA, 10)));
        companyInfo.add(new Chunk("13000 Marseille\n", FontFactory.getFont(FontFactory.HELVETICA, 10)));
        companyInfo.add(new Chunk("Téléphone : 01 23 45 67 89\n", FontFactory.getFont(FontFactory.HELVETICA, 10)));
        companyInfo.add(new Chunk("Email : contact@monentreprise.com", FontFactory.getFont(FontFactory.HELVETICA, 10)));
    
        companyInfoCell.addElement(companyInfo);
        headerTable.addCell(companyInfoCell);
    
        // Add the header table to the document
        document.add(headerTable);
        document.add(new Paragraph("\n"));  // Add spacing after the header
    }

}