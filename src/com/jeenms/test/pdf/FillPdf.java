package com.jeenms.test.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;  
  
public class FillPdf {  
    // 利用模板生成pdf  
    public static void fillTemplate() {  
        // 模板路径  
        String templatePath = "./测试-模板.pdf";  
        // 生成的新文件路径  
        String newPDFPath = "./ceshi.pdf";  
        PdfReader reader;  
        FileOutputStream out;  
        ByteArrayOutputStream bos;  
        PdfStamper stamper;  
        Document doc = new Document();  
        try {  
            out = new FileOutputStream(newPDFPath);// 输出流  
            reader = new PdfReader(templatePath);// 读取pdf模板  
            bos = new ByteArrayOutputStream();  
            stamper = new PdfStamper(reader, bos);  
            AcroFields form = stamper.getAcroFields();  
  
            String[] str = { "123456789", "TOP__ONE", "男", "1991-01-01", "130222111133338888", "河北省保定市" };  
            int i = 0;  
            java.util.Iterator<String> it = form.getFields().keySet().iterator();  
            while (it.hasNext()) {  
                String name = it.next().toString();  
                System.out.println(name);  
                form.setField(name, str[i++]);
            }
            
            //插入图片	
            Image img = Image.getInstance("./qrcode.png");//选择图片
            img.setAlignment(Image.LEFT | Image.TEXTWRAP);  
            img.setBorder(Image.BOX);  
            img.setBorderWidth(10);  
            img.setBorderColor(BaseColor.WHITE);  
            img.setAbsolutePosition(280, 500); 
            img.scaleToFit(100, 72);//大小  
            //img.setRotationDegrees(-30);//旋转  
            // Text over the existing page 
            PdfContentByte over = stamper.getOverContent(1); 
            over.addImage(img); 
            
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true  
            stamper.close();  
  
            PdfCopy copy = new PdfCopy(doc, out);  
            doc.open();  
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);  
            copy.addPage(importPage);  
 
              
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  finally {
        	doc.close();
		}
  
    }  
  
    public static void main(String[] args) {  
        fillTemplate();  
    }  
}  