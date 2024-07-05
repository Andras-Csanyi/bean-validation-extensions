package com.andrascsanyi.beanvalidationextensions.longvaluemustbe;

import com.andrascsanyi.beanvalidationextensions.LongValueMustBe;
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

    @LongValueMustBe(
        mustBe = 1,
        message = "Custom Error Message"
    )
    private Long id;
}
