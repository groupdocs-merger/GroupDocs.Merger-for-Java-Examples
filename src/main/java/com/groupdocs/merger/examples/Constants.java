package com.groupdocs.merger.examples;

import java.io.File;

public class Constants {

    public static boolean IsLicensed = false;

    public static String LicensePath = "E:\\GroupDocs.Merger.Java.lic";


    public static String SamplesPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\");
    public static String SamplesPdfPath = (System.getProperty("user.dir") + "\\Resources\\SampleFiles\\pdf\\");

    public static String OutputPath = (System.getProperty("user.dir") + "\\Output\\");

    private static String getSampleFilePath(String filePath) {
        return new File(SamplesPath, filePath).getPath();
    }

    public static String getOutputDirectoryPath(String callerFilePath )
    {
        return new File(OutputPath, callerFilePath).getPath();
    }
}
