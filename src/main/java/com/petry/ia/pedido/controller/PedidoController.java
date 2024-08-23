package com.petry.ia.pedido.controller;

import java.util.List;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	OpenAiChatModel openAiChatModel;
	
	@GetMapping
	public String teste() {
		

		ChatResponse response = openAiChatModel.call(
			    new Prompt(
			        "crie uma receita de bolo para mim",
			        OpenAiChatOptions.builder()
			            .withModel(OpenAiApi.ChatModel.GPT_3_5_TURBO)
			            .withTemperature(0.4F)
			        .build()
			    ));
		
		return response.getResult().getOutput().getContent();
	}
}
