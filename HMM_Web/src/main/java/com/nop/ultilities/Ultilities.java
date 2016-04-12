package com.nop.ultilities;

import java.io.File;
import java.util.ArrayList;

import com.nop.DTO.Bill;
import com.nop.DTO.Person;

public class Ultilities {
	public static double parseInDouble(Object value){
		double result=0;
			if(value==null) return 0;
			else
			if(value.toString().length()==0) return 0;
			else
				result=Double.valueOf(value.toString());
		return result;
	}
	
	public static Person copyPerson(Person source){
		Person value=null;
		if(source!=null){
			value=new Person();
			value.setPersonID(source.getPersonID());
			value.setPersonName(source.getPersonName());
		}
		return value;
	}
	
	public static Bill copyBill(Bill source){
		Bill value=null;
		if(source!=null){
			value=new Bill();
			value.setBillID(source.getBillID());
			value.setDescription(source.getDescription());
			value.setAmountMoney(source.getAmountMoney());
			value.setMonth(source.getMonth());
			value.setPayer(source.getPayer());
		}
		return value;
	}
	public static String parseString(int intValue) {
        if (intValue == Integer.MIN_VALUE) {
            return "";
        }
        return String.valueOf(intValue);
    }
 
    public static String parseString(Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return "";
        }
    }
 
    public static String parseString(double doubleValue) {
        if (doubleValue == Double.NEGATIVE_INFINITY) {
            return "";
        }
        return String.valueOf(doubleValue);
    }
 
    public static String convertString(Object obj) {
        String str = "";
        if (obj instanceof Double) {
            if ((Double) obj == Double.NEGATIVE_INFINITY) {
                return "";
            }
        }
        str = String.valueOf(obj);
        if (str.indexOf(".") > 0) {
            int index = str.lastIndexOf("0");
            while (index == str.length() - 1) {
                str = str.substring(0, index);
                index = str.lastIndexOf("0");
            }
            if (str.lastIndexOf(".") == str.length() - 1)
                str = str.substring(0, str.lastIndexOf("."));
        }
        return str;
    }
     
    public static String removeLastCharacter(String org , String pattern) {
        String result=org;
        if(org.lastIndexOf(pattern) > 0) {
            result = org.substring(0, org.lastIndexOf(pattern));
        }
        return result;
    }
     
    public static String removeTheLatestCharacter(String org , String[] arg) {
        String result=org;
        org = org.trim();
        String chars = org.substring(org.length() - 1, org.length());
        if(checkStringExistInArray(arg,chars)) {
            result = org.substring(0, org.length() - 1);
        }
        return result;
    }
     
    private static boolean checkStringExistInArray(String[] args , String ch){
        for(String s : args){
            if(ch.equals(s)) return true;
        }
        return false;
    }
    public static int parseInt(Object obj) {
        try {
            if (obj != null) {
                return Integer.parseInt(obj.toString().replaceAll(",", ""));
            }
        } catch (Exception e) {
        }
        return Integer.MIN_VALUE;
    }
 
    public static int parseInt2(Object obj) {
        try {
            if (obj != null) {
                String s = obj.toString();
                return new Double(s).intValue();
            }
        } catch (Exception e) {
        }
        return Integer.MIN_VALUE;
    }
     
    public static byte parseByte(Object obj) {
        try {
            if (obj != null) {
                String s = obj.toString();
                return new Double(s).byteValue();
            }
        } catch (Exception e) {
        }
         
        return Byte.MIN_VALUE;
    }
 
    public static short parseShort(Object obj) {
        try {
            if (obj != null) {
                String s = obj.toString();
                return new Double(s).shortValue();
            }
        } catch (Exception e) {
        }
         
        return Short.MIN_VALUE;
    }
 
    /**
     * 
     * @param str
     * @param value
     * @return value if not a number
     */
    public static int parseInt(String str, int value) {
        try {
            if (str.trim().length() > 0) {
                return Integer.parseInt(str.replaceAll(",", ""));
            }
        } catch (Exception e) {
        }
        return value;
    }
 
    /**
     * 
     * @param obj
     * @return Double.NEGATIVE_INFINITY if not a number
     */
 
    public static double parseDouble(Object obj) {
        try {
            if (obj != null) {
                return Double.parseDouble(obj.toString().replaceAll(",", "")
                        .replaceAll("i", ""));
            }
        } catch (Exception e) {
        }
        return Double.NEGATIVE_INFINITY;
    }
 
    public static double parseDoubleWithPerformance(Object obj) {
        try {
            if (obj != null && !"".equals(obj)) {
                return Double.parseDouble(obj.toString().replaceAll(",", "")
                        .replaceAll("i", ""));
            }
        } catch (Exception e) {
        }
        return Double.NEGATIVE_INFINITY;
    }
 
    /**
     * 
     * @param str
     * @param value
     * @return value if not a number
     */
    public static double parseDouble(String str, double value) {
        try {
            if (str.trim().length() > 0) {
                return Double.parseDouble(str.replaceAll(",", "").replaceAll(
                        "i", ""));
            }
        } catch (Exception e) {
        }
        return value;
    }
	/**
	 * type =0: search maxID between lstBill and lstRentBill
	 * type=1: search maxID in lstBill only
	 * @param type
	 * @param lstBills
	 * @param lstRentBill
	 * @return
	 */
	public static int generateIDForBill(int type,ArrayList lstBills, ArrayList lstRentBill){
		if(type==0){
			int maxOne=findMaxId(lstBills);
			int maxTwo=findMaxId(lstRentBill);
			if (maxOne>maxTwo) 
				return ++maxOne;
			else
				return ++maxTwo;
		}else{
			int maxOne=findMaxId(lstBills);
			return ++maxOne;
		}
	}
	
	public static int findMaxId(ArrayList lst){
		int max=0;
		for(int i=0;i<lst.size();i++){
			if(lst.get(i) instanceof Bill){
				 Bill object= (Bill)lst.get(i);
				if(object.getBillID()>max){
					max=object.getBillID();
				}
			}else if(lst.get(i) instanceof Person){
				 Person object= (Person)lst.get(i);
					if(object.getPersonID()>max){
						max=object.getPersonID();
					}
			}
		}
		return max;
	}
	
	public static boolean isExistedFile(String name){
		File file=new File(name);
		if(file.exists())
			return true;
		else
			return false;
	}
}
