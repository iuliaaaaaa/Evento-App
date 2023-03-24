package evento.controller;

import com.google.zxing.WriterException;
import evento.business.QRCode.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/qrcode")
@RequiredArgsConstructor
public class QRCodeController {
    @GetMapping("/user/{user}/event/{event}")
    public String getQRCode(Model model, @PathVariable(value = "user") String user, @PathVariable(value = "event") String event){
        String path = "./src/main/resources/qrCodes/" + user + "at" +  event + ".png";
        String ticket= user + event;

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(ticket,250,250);

            // Generate and Save Qr Code Image in static/image folder
            QRCodeGenerator.generateQRCodeImage(ticket,250,250,path);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);


        model.addAttribute("ticket",ticket);
        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }

    @GetMapping("/{id}")
    public String getQRCode(Model model, @PathVariable(value = "id", required = false) String id) {
    return null;
    }
}
