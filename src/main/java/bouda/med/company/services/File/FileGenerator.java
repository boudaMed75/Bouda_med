package bouda.med.company.services.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class FileGenerator {

   public byte[] generateBankStatement(String accountNumber, String bankName,
                                    String address, String statementDate, String statementPeriod,
                                    String accountHolder, double balance) throws DocumentException, IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // Création du document
    Document document = new Document(PageSize.A4, 36, 36, 80, 60);
    

    // Création du writer avec l'ajout de l'événement pour l'en-tête et le pied de page
    PdfWriter writer = PdfWriter.getInstance(document, baos);
    
    // Créer l'événement pour ajouter l'en-tête et le pied de page
    String logoPath = System.getProperty("user.dir") + "/uploads/imgProfil/null_0db36cf4.png" ; // Chemin vers le logo
    String footerText = "Informations de l'entreprise - Contact: info@entreprise.com";
    writer.setPageEvent(new HeaderFooter(logoPath, footerText));
    

    // Ouverture du document

    document.open();
    

    // Ajout du titre
    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.BLUE);
    Paragraph title = new Paragraph("Relevé Bancaire", titleFont);
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);

    Font font = FontFactory.getFont(FontFactory.HELVETICA, 12); // Police et taille
            Paragraph paragraph = new Paragraph("   Bonjour les encadrants et les enseignant de BOUDA MED COMPANY . ahujourdhui'hui le 10-11-2024 , nous allons effectue le renion de Lancement de Projet S5(Licence Parcous d'Exellence). et nous allons arrive a les Rusultat a dessus dans ce documents", font);
            paragraph.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
            paragraph.setSpacingBefore(20); // Espacement avant le paragraphe
            paragraph.setSpacingAfter(20); 
    document.add(paragraph);

    Font tiFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
    Paragraph title1 = new Paragraph("S5 Parcours d'exellence SDIA  entre le 11-11-2024 et le 20-02-2025", tiFont);
    title1.setAlignment(Element.ALIGN_CENTER);
    document.add(title1);


    // Ajout des informations sur le compte
    Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
    Paragraph info = new Paragraph();

    info.add(new Paragraph("    1 - 11 - 11 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 18 - 11 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 26 - 11 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 02 - 12 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 09 - 12 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 16 - 12 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 23 - 12 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 30 - 11 - 2024" , infoFont));
    info.add(new Paragraph("    1 - 06 - 01 - 2025" , infoFont));
    info.add(new Paragraph("    1 - 13 - 01 - 2025" , infoFont));
    info.add(new Paragraph("    1 - 20 - 01 - 2025" , infoFont));
    document.add(info);


    
    Paragraph title2 = new Paragraph("Renion inclue dans S5 Parcours d'exellence SDIA", tiFont);
    title1.setAlignment(Element.ALIGN_CENTER);
    document.add(title2);

    // // Ajout des informations sur le relevé
    // Paragraph statementInfo = new Paragraph();
    // statementInfo.add(new Paragraph("Date du relevé: " + statementDate, infoFont));
    // statementInfo.add(new Paragraph("Période du relevé: " + statementPeriod, infoFont));
    // statementInfo.add(new Paragraph(" ", infoFont)); // Espacement
    // document.add(statementInfo);

    // Ajout du tableau de transactions
    PdfPTable table = new PdfPTable(3);
    table.setWidthPercentage(100);
    table.setSpacingBefore(10f);
    table.setSpacingAfter(10f);

    // En-têtes du tableau
Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
PdfPCell headerCell = new PdfPCell();
headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
headerCell.setPadding(5);
headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);

// Définir les en-têtes
headerCell.setPhrase(new Paragraph("Mois", tableHeaderFont));
table.addCell(headerCell);

headerCell.setPhrase(new Paragraph("Date Réunion", tableHeaderFont));
table.addCell(headerCell);

headerCell.setPhrase(new Paragraph("Local", tableHeaderFont));
table.addCell(headerCell);

// Exemple de données (ligne 1)
Font tableDataFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

// Première ligne
table.addCell(new PdfPCell(new Paragraph("Décembre", tableDataFont)));
table.addCell(new PdfPCell(new Paragraph("08 - 12 - 2024", tableDataFont)));
table.addCell(new PdfPCell(new Paragraph("Trabzoun", tableDataFont)));

// Deuxième ligne
table.addCell(new PdfPCell(new Paragraph("Décembre", tableDataFont)));
table.addCell(new PdfPCell(new Paragraph("09 - 12 - 2024", tableDataFont)));
table.addCell(new PdfPCell(new Paragraph("Ankara", tableDataFont)));

// Troisième ligne
table.addCell(new PdfPCell(new Paragraph("Janvier", tableDataFont)));
table.addCell(new PdfPCell(new Paragraph("10 - 01 - 2025", tableDataFont)));
table.addCell(new PdfPCell(new Paragraph("Istanbul", tableDataFont)));

// Ajouter le tableau au document
document.add(table);


    // Ajout du solde final
    Font balanceFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLUE);
    Paragraph balanceParagraph = new Paragraph("Solde final: " + balance + " DH", balanceFont);
    balanceParagraph.setAlignment(Element.ALIGN_RIGHT);
    document.add(balanceParagraph);

    document.newPage();

    
    Paragraph moduleTitle = new Paragraph("Les modules Inclue Dans S5 Parcours D'exellence", tiFont);
    title1.setAlignment(Element.ALIGN_CENTER);
    document.add(moduleTitle);

    


    // Fermeture du document
    document.close();

    // Renvoi du contenu du ByteArrayOutputStream
    return baos.toByteArray();
}
    
}
