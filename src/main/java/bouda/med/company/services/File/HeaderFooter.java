package bouda.med.company.services.File;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class HeaderFooter extends PdfPageEventHelper {

    private String companyLogoPath; // Chemin vers le logo
    private String footerText;      // Texte du pied de page

    public HeaderFooter(String companyLogoPath, String footerText) {
        this.companyLogoPath = companyLogoPath;
        this.footerText = footerText;
    }

    /**
     * Méthode pour ajouter l'en-tête
     */
    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            PdfContentByte canvas = writer.getDirectContent();
            
            // Ajouter le logo dans l'en-tête
            Image logo = Image.getInstance(companyLogoPath);
            logo.scaleToFit(50, 50); // Taille du logo
            logo.setAbsolutePosition(document.leftMargin(), document.top() + 10); // Positionnement
            canvas.addImage(logo);

            // Ajouter le texte de l'en-tête
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLUE);
            Phrase headerPhrase = new Phrase("Nom de l'Entreprise", headerFont);

            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, headerPhrase,
                    (document.right() + document.left()) / 2, document.top() + 25, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour ajouter le pied de page
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            PdfContentByte canvas = writer.getDirectContent();

            // Ajouter une ligne au-dessus du pied de page
            canvas.setLineWidth(0.5f);
            canvas.setGrayStroke(0.8f);
            canvas.moveTo(document.leftMargin(), document.bottom() - 10);
            canvas.lineTo(document.right() + document.leftMargin(), document.bottom() - 10);
            canvas.stroke();

            // Ajouter le texte du pied de page
            Font footerFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);
            Phrase footerPhrase = new Phrase(footerText, footerFont);

            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, footerPhrase,
                    (document.right() + document.left()) / 2, document.bottom() - 20, 0);

            // Ajouter le numéro de page
            String pageNumber = "Page " + writer.getPageNumber();
            Phrase pagePhrase = new Phrase(pageNumber, footerFont);

            ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, pagePhrase,
                    document.right(), document.bottom() - 20, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
