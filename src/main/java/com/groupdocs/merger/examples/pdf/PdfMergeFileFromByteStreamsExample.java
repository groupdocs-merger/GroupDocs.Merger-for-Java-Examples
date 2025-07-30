package com.groupdocs.merger.examples.pdf;

import com.groupdocs.merger.Merger;
import com.groupdocs.merger.domain.options.JoinOptions;
import com.groupdocs.merger.examples.Constants;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PdfMergeFileFromByteStreamsExample {
    public static void run() throws Exception
    {
        Path pdfDirectory = Paths.get(Constants.SamplesPdfPath);

        List<String> pdfFilePaths = Files.list(pdfDirectory)
                .filter(path -> path.toString().toLowerCase().endsWith(".pdf"))
                .map(Path::toString)
                .collect(Collectors.toList());

        if(pdfFilePaths.isEmpty())return;

        List<byte[]> pdfByteArrays = new ArrayList<>();
        for (String path : pdfFilePaths) {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            pdfByteArrays.add(bytes);
        }

        ByteArrayOutputStream mergedPdfOutputStream = new ByteArrayOutputStream();

        try (InputStream firstPdfInputStream = new ByteArrayInputStream(pdfByteArrays.get(0))) {
            Merger merger = new Merger(firstPdfInputStream);

            for (int i = 1; i < pdfByteArrays.size(); i++) {
                try (InputStream pdfInputStream = new ByteArrayInputStream(pdfByteArrays.get(i))) {
                    merger.join(pdfInputStream, new JoinOptions());
                }
            }

            merger.save(mergedPdfOutputStream);
        } catch (Exception e) {
            throw new RuntimeException("Error 1", e);
        }

        try (FileOutputStream fos = new FileOutputStream("PdfMergeFileFromByteStreamsExample_output.pdf")) {
            mergedPdfOutputStream.writeTo(fos);
        }

        System.out.println("Done PdfMergeFileFromByteStreamsExample_output.pdf");
    }
}
