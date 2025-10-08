package com.groupdocs.merger.examples.pdf;

import com.groupdocs.merger.Merger;
import com.groupdocs.merger.domain.options.PdfSaveOptions;

public class PdfAutoTaggingExample {
    public static void run()
    {
        String filePath = "sample_bookmarks.pdf";

        String filePathOut = "result.pdf";

        PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();

        pdfSaveOptions.getAccessibilitySettings().setEnableAutoTagging(true);

        try {
            Merger merger = new Merger(filePath);
            merger.save(filePathOut, pdfSaveOptions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
