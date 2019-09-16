package com.Person;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class perSon {
	
	 

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
	       String[] strArray=new String[20000];
	        int i=0;
			InputStream is = new FileInputStream("/Users/ann/eclipse-workspace/FindPerson/src/com/Person/Homework1In.txt");
	        String line; // 用来保存每行读取的内容
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	        line = reader.readLine(); // 读取第一行
	        strArray[i]=line;
	        i++;

			FileOutputStream os = new FileOutputStream("/Users/ann/eclipse-workspace/FindPerson/src/com/Person/Homework1Out.txt");
	        //String line; // 用来保存每行读取的内容
	        OutputStreamWriter writer = new OutputStreamWriter(os);
	        
	        
	        while (line != null) { // 如果 line 为空说明读完了
	            //buffer.append(line); // 将读到的内容添加到 buffer 中
	            //buffer.append("\n"); // 添加换行符
	            line = reader.readLine(); // 读取下一行
	            strArray[i]=line;
	            i++;
	        }
	        reader.close();
	        is.close();
	       String str=new String();
	       for(int j=0;j<i-1;j++) {
	        str=strArray[j];
	        String[] str1=str.split(",");
	        
	        String name=str1[0];
	        
	        Map m11=new HashMap();
	        m11.put("\r\n"+"\"姓名\"","\""+name+"\"");
	        str=str.replace(name,"");
	        str=str.replace(",","");
	        str=str.replace(".","");
	        String Telphone=null;
	        String TelephoneNumber="\\d{11}";
	        Matcher a = Pattern.compile(TelephoneNumber).matcher(str);
	        while (a.find()){
	       	 Telphone=a.group();
	            str=str.replace(Telphone,"");
	          }
	        m11.put("\r\n"+"\"手机\"","\""+Telphone+"\"");
	        ArrayList<String>address=new ArrayList<String>();
	        String province;
	        String city;
	        String county;
	        String town;
	        String detail;
	        String detailstreet;
	        String detailnum;
	        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<detail>.*)";
	        Matcher b=Pattern.compile(regex).matcher(str);
	        while(b.find()) {
	       	 province=b.group("province");
	       	 address.add((province==null)?"":"\r\n"+"\""+province.trim()+"\"");
	       	 city=b.group("city");
	       	 address.add((city==null)?"":"\r\n"+"\""+city.trim()+"\"");
	       	 county=b.group("county");
	       	 address.add((county==null)?"":"\r\n"+"\""+county.trim()+"\"");
	       	 town=b.group("town");
	       	 address.add((town==null)?"":"\r\n"+"\""+town.trim()+"\"");
	       	 detail=b.group("detail");
	       	 address.add((detail==null)?"":"\r\n"+"\""+detail.trim()+"\"");
	        }
	       	 m11.put("\"地址\"","\r\n"+ address);
	       	 String c11=m11.toString();
	       	 c11=c11.replace("=",":");
	       	System.out.println(c11);
	         
		      
		        //line = reader.readLine(); // 读取第一行
		       // strArray[i]=line;
		       // i++;
		        writer.append(c11);
		        writer.append("\r\n");
		        
	        }

			writer.close();
	      // System.out.println(writer.toString());
	       }
		
	}
      
       
     
    //String str="李四,福建省福州13756899511市鼓楼区鼓西街道湖滨路110号湖滨大厦一层.";
     
	
     

     
     
	
     


