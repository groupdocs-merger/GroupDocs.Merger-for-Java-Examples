package com.groupdocs.merger.examples.pdf;

import com.groupdocs.merger.Merger;
import com.groupdocs.merger.examples.Constants;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PdfMergeCommonExample {
    public static void run() throws Exception
    {
        Path pdfDirectory = Paths.get(Constants.SamplesPdfPath);

        List<String> pdfFilePaths = Files.list(pdfDirectory)
                .filter(path -> path.toString().toLowerCase().endsWith(".pdf"))
                .map(Path::toString)
                .sorted()
                .collect(Collectors.toList());

        if(pdfFilePaths.isEmpty())return;

        Merger merger = new Merger(pdfFilePaths.get(0));

        for (int i = 1; i < pdfFilePaths.size(); i++) {
            merger.join(pdfFilePaths.get(i));
        }

        merger.save("PdfMergeCommonExample_output.pdf");

        System.out.println("Done PdfMergeCommonExample_output.pdf");
    }
}
