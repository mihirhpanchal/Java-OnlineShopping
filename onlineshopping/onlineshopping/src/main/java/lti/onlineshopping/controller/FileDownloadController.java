package lti.onlineshopping.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/download")
public class FileDownloadController {

	@RequestMapping(value="/pdf", method=RequestMethod.GET)
    public void downloadPDFResource( HttpServletRequest request,HttpServletResponse response) 
    //, @PathVariable("fileName") String fileName) 
    {
		String fileName=request.getParameter("fileName"); 
        String dataDirectory = System.getProperty("catalina.home")+ File.separator + "tempfiles";
        System.out.println(fileName+"  "+dataDirectory);
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) 
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
	
	@RequestMapping(value="/image", method=RequestMethod.GET)
	public void downloadImageResource( HttpServletRequest request,HttpServletResponse response)
    {
		String fileName=request.getParameter("fileName"); 
        //String dataDirectory = "c:\\tempfiles"; 
		String dataDirectory =  System.getProperty("catalina.home")+ File.separator + "tempfiles"; 
        System.out.println("filename:"+fileName+"\nDir:"+dataDirectory);
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) 
        {
            response.setContentType("image/jpg");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
