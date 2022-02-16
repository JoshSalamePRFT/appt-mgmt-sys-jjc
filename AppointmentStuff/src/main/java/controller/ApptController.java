package controller;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import service.ApptService;

@RestController
@CrossOrigin
@Data
public class ApptController {
    private ApptService apptService;
}
