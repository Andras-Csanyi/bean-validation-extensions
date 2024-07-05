package com.andrascsanyi.beanvalidationextensions.longasstringmustbegreaterorequaltoone;

import com.andrascsanyi.beanvalidationextensions.LongAsStringMustBeGreaterOrEqualToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomErrorMessageEntity {

    @LongAsStringMustBeGreaterOrEqualToOne(message = "Custom Error Message")
    private String id;
}
