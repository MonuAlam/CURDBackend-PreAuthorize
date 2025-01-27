package com.curd.model.request;

import jakarta.validation.constraints.NotBlank;
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
public class NotesRequest {

	@NotBlank(message = "Title can not be blank")
	private String title;

	@NotBlank(message = "Description can not be blank")
	private String description;

}
