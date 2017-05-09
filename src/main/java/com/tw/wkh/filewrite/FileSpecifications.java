package com.tw.wkh.filewrite;

public class FileSpecifications {
    private LineFormatter formatter;
    private String query;
    private String filename;

    public FileSpecifications(String filename, String query, LineFormatter formatter){
        this.filename = filename;
        this.query = query;
        this.formatter = formatter;
    }

    public String query(){
        return query;
    }

    public LineFormatter formatter(){
        return formatter;
    }

    public String filename(){
        return filename;
    }
}
