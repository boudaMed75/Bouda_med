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

import bouda.med.company.models.Chapitre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.models.SousModules;
import bouda.med.company.models.Taches;

@Service
public class FileRenionImplement implements FileRenionService {

    @Override
    public byte[] generateRenionSumary(Projet projet) throws DocumentException, IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document document = new Document(PageSize.A4,36,36,80,86) ;

        PdfWriter writer = PdfWriter.getInstance(document, baos);

        String logoPath = System.getProperty("user.dir") + "/uploads/imgProfil/null_0db36cf4.png" ; // Chemin vers le logo

        String footerText = "Informations de l'entreprise - Contact: info@entreprise.com";
        
        writer.setPageEvent(new HeaderFooter(logoPath, footerText));


        //Ouverture du document
        document.open();


        // 

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.BLUE);
        Paragraph title = new Paragraph("Renion Resumee", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);

        document.add(title);

        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12); // Police et taille
        Paragraph paragraph = new Paragraph("   Bonjour les encadrants et les enseignant de " + projet.getName()+" . ahujourdhui'hui le 10-11-2024 , nous allons effectue le renion de Lancement de Projet S5(Licence Parcous d'Exellence). et nous allons arrive a les Rusultat a dessus dans ce documents", font);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
        paragraph.setSpacingBefore(20); // Espacement avant le paragraphe
        paragraph.setSpacingAfter(20); 
        document.add(paragraph);

        Font tiFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Paragraph title1 = new Paragraph(projet.getName() + "  entre le " +projet.getStart_date() +" et le " + projet.getName(), tiFont);
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
        Font tableDataFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

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


        document.add(table);

        document.newPage();


        // MODULE AND ENCADRANT PAGE

        PdfPTable moduleTab = new PdfPTable(3);
        moduleTab.setWidthPercentage(100);
        moduleTab.setSpacingBefore(10f);
        moduleTab.setSpacingAfter(10f);
         // En-têtes du tableau
         
         PdfPCell moduleTable = new PdfPCell();
         moduleTable.setBackgroundColor(BaseColor.DARK_GRAY);
         moduleTable.setPadding(5);
         moduleTable.setHorizontalAlignment(Element.ALIGN_CENTER);
 
         // Définir les en-têtes
         moduleTable.setPhrase(new Paragraph("ID MODULE", tableHeaderFont));
         moduleTab.addCell(moduleTable);
 
         moduleTable.setPhrase(new Paragraph("NAME", tableHeaderFont));
         moduleTab.addCell(moduleTable);
 
         moduleTable.setPhrase(new Paragraph("ENCADRANTS", tableHeaderFont));
         moduleTab.addCell(moduleTable);

        for (Modules ele : projet.getModules()) {
            moduleTab.addCell(new PdfPCell(new Paragraph(ele.getId(), tableDataFont)));
            moduleTab.addCell(new PdfPCell(new Paragraph(ele.getName(), tableDataFont)));
            moduleTab.addCell(new PdfPCell(new Paragraph("MR " +ele.getEncadrant().getNom()  + " " + ele.getEncadrant().getPrenom(), tableDataFont)));

            
        }

        document.add(moduleTab);



        // Ajouter le tableau au document
        document.close();




        
        return baos.toByteArray();
        
    }

    @Override
    public byte[] generateRenionSumaryOld(Projet projet) throws DocumentException, IOException {
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
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.BLUE);
        Paragraph title = new Paragraph("Project Informations " + projet.getName() , titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12); // Police et taille
            Paragraph paragraph = new Paragraph("   Le projet "+projet.getName() + " " + projet.getDescription() + " entre le " + projet.getStart_date() + " jusqu'a " + projet.getEnd_date(), font);
            paragraph.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
            paragraph.setSpacingBefore(20); // Espacement avant le paragraphe
            paragraph.setSpacingAfter(20); 
        document.add(paragraph);


         // En-têtes du tableau
         
         Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
         Font tableDataFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        Font tiFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Paragraph title1 = new Paragraph("Les modules Inclues dans " + projet.getName(), tiFont);
        title1.setAlignment(Element.ALIGN_CENTER);
        document.add(title1);

        PdfPTable moduleTab = new PdfPTable(3);
        moduleTab.setWidthPercentage(100);
        moduleTab.setSpacingBefore(10f);
        moduleTab.setSpacingAfter(10f);
         // En-têtes du tableau
         
         PdfPCell moduleTable = new PdfPCell();
         moduleTable.setBackgroundColor(BaseColor.DARK_GRAY);
         moduleTable.setPadding(5);
         moduleTable.setHorizontalAlignment(Element.ALIGN_CENTER);
 
         // Définir les en-têtes
         moduleTable.setPhrase(new Paragraph("ID MODULE", tableHeaderFont));
         moduleTab.addCell(moduleTable);
 
         moduleTable.setPhrase(new Paragraph("NAME", tableHeaderFont));
         moduleTab.addCell(moduleTable);
 
         moduleTable.setPhrase(new Paragraph("ENCADRANTS", tableHeaderFont));
         moduleTab.addCell(moduleTable);

        for (Modules ele : projet.getModules()) {
            moduleTab.addCell(new PdfPCell(new Paragraph(ele.getId(), tableDataFont)));
            moduleTab.addCell(new PdfPCell(new Paragraph(ele.getName(), tableDataFont)));
            moduleTab.addCell(new PdfPCell(new Paragraph("MR " +ele.getEncadrant().getNom()  + " " + ele.getEncadrant().getPrenom(), tableDataFont)));

            
        }

        document.add(moduleTab);
        document.newPage();

        for (Modules ele : projet.getModules()) {

            Paragraph moduleTitle = new Paragraph(ele.getName(), tiFont);
            document.add(moduleTitle);


            Paragraph moduleDescription = new Paragraph(ele.getDescription() + "NB :  De " + ele.getEnd_date() + " au " + ele.getEnd_date(), font);

            moduleDescription.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
            moduleDescription.setSpacingBefore(20); // Espacement avant le paragraphe
            moduleDescription.setSpacingAfter(20); 


            document.add(moduleDescription);

            int i = 1 ; 


            for (SousModules eModules : ele.getSousModules()) {

                Paragraph sousmoduleTitle = new Paragraph(i + " - " + eModules.getName(), tiFont);
                document.add(sousmoduleTitle);

                Paragraph sousmoduleDescription = new Paragraph(eModules.getDescription() + "NB :  De " + eModules.getEnd_date() + " au " + eModules.getEnd_date(), font);

                sousmoduleDescription.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
                sousmoduleDescription.setSpacingBefore(20); // Espacement avant le paragraphe
                sousmoduleDescription.setSpacingAfter(20); 

                document.add(sousmoduleDescription);

                int chapitre = 1 ;

                for (Chapitre eChapitre : eModules.getChapitres()) {

                    Paragraph chapitreTitle = new Paragraph(chapitre + " - " + eChapitre.getName(), tiFont);
                    document.add(chapitreTitle);


                    if(eChapitre.getTaches().isEmpty()){
                        Paragraph notFound = new Paragraph("Aucun Tache Trouve", font);

                        notFound.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
                        notFound.setSpacingBefore(20); // Espacement avant le paragraphe
                        notFound.setSpacingAfter(20); 

                        document.add(notFound);
                    }

                    else{
                        int tache = 1 ; 
                        for (Taches eTaches : eChapitre.getTaches()) {

                            Paragraph notFound = new Paragraph(tache + " - " + eTaches.getName(), font);

                            notFound.setAlignment(Paragraph.ALIGN_LEFT); // Alignement à gauche
                            notFound.setSpacingBefore(20); // Espacement avant le paragraphe
                            notFound.setSpacingAfter(20); 

                            document.add(notFound);

                            tache ++ ;
                            
                        }

                    }


                    chapitre ++ ;

                    
                }

                i ++ ;

                
                
            }

            document.newPage();



            
        }


        document.close();

        return baos.toByteArray();
        
    }

    


    
}
