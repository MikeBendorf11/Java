package AfollowsTheObj;

public class AEmployee {
    int yearOfBirth;
    
    void setYearOfBirth(int x) {
        yearOfBirth = x;
        x = -1;      // modify local variable copy
    }

}
