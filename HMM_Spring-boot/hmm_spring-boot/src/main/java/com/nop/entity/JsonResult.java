package com.nop.entity;

import java.util.List;

public class JsonResult<T> {

    public String Result = "ERROR";
    public List<T> Records;
    public List<T> Options;
    public T Record;
    public String Message = "Error message: Must be create Json constructor.";
    public long TotalRecordCount;
}