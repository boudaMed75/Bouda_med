package bouda.med.company.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import bouda.med.company.services.File.FileGenerator;
import bouda.med.company.services.File.InvoicePdfService;
import bouda.med.company.user.PublicService.PublicService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/v1/admin/pdf")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class PdfController {
    
    @Autowired
    private PublicService publicService ;

    @Autowired
    private InvoicePdfService invoicePdfService;

    @GetMapping("/generate-invoice")
    public void generateInvoice(HttpServletResponse response) {
        invoicePdfService.generateInvoice(response);
    }

    

    @GetMapping("/generate-bank-statement")
    public ResponseEntity<byte[]> generateBankStatement(@RequestParam String id) throws DocumentException, IOException {

        // Générer le PDF à partir des paramètres
        byte[] pdfContents = publicService.getRenioSumary(id);

        // Créer les en-têtes de la réponse HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "bank_statement.pdf");
        headers.setContentLength(pdfContents.length);

        // Retourner le PDF en réponse
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContents);
    }

    @GetMapping("/project_details_file")
    public ResponseEntity<byte[]> getProjetDetails(@RequestParam String id) throws DocumentException, IOException {

        // Générer le PDF à partir des paramètres
        byte[] pdfContents = publicService.getRenioSumaryOld(id);

        // Créer les en-têtes de la réponse HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "bank_statement.pdf");
        headers.setContentLength(pdfContents.length);

        // Retourner le PDF en réponse
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContents);
    }
}
