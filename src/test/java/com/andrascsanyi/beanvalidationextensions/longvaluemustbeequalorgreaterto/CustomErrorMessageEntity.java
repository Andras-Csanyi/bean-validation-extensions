package com.andrascsanyi.beanvalidationextensions.longvaluemustbeequalorgreaterto;

import com.andrascsanyi.beanvalidationextensions.LongValueMustBeGreaterOrEqualTo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorMessageEntity {
    
    @LongValueMustBeGreaterOrEqualTo(
        mustBeGreaterOrEqualTo = 1,
        message = "Custom Error Message"
    )
    private Long id;
}
