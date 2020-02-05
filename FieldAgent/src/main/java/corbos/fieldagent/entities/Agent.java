package corbos.fieldagent.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class Agent {

    @NotBlank(message = "Identifier must not be empty.")
    @Size(max = 5, message="Identifier must be less than 5 characters.")
    @Id
    private String identifier;
    
    @NotBlank(message = "First name must not be empty.")
    @Size(max = 30, message="First name must be less than 30 characters.")
    private String firstName;
    
    private String middleName;
    
    @NotBlank(message = "Last name must not be empty.")
    @Size(max = 30, message="Last name must be less than 30 characters.")
    private String lastName;
    
    private String pictureUrl;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    
    @Min(value=36, message="Height must be greater than 36 Inches.")
    @Max(value=90, message="Height must be less than 90 Inches.")
    private int height;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate activationDate;
    
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "security_clearance_id")
    private SecurityClearance securityClearance;

}
