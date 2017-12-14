package com.nop.entity;

import java.util.List;

public class Json<T> extends JsonResult<T> {     
public Json(String Result) {         
    this.Result = Result;     
}     
public Json( String Result, List<T> Records, long TotalRecordCount){         
    this.Result = Result;         
    this.Records = Records;         
    this.TotalRecordCount = TotalRecordCount;
}     
public Json( String Result, List<T> Options){         
    this.Result = Result;         
    this.Options = Options;     
}     
public Json( String Result, String Message){         
    this.Result = Result;         
    this.Message = Message;     
}     
public Json( String Result, T Record){         
    this.Result = Result;         
    this.Record = Record;     
}    
public Json(){} } 