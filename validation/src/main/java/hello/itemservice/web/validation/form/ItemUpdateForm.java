package hello.itemservice.web.validation.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class ItemUpdateForm {

	@NotNull
	private String id;

	@NotBlank
	private String itemName;

	@NotNull
	@Range(min = 1000, max = 1000000)
	private Integer price;

	// 수정에서는 수량을 자유롭게 변경할 수 있다.
	private Integer quantity;

}
