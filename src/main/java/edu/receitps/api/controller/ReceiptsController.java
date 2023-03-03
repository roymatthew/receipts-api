package edu.receitps.api.controller;

import edu.receitps.api.dto.Receipt;
import edu.receitps.api.exception.ReceiptNotFoundException;
import edu.receitps.api.service.ReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ReceiptsController {

	private ReceiptsService receiptsService;

	public ReceiptsController(ReceiptsService receiptsService) {
		this.receiptsService = receiptsService;
	}

	@GetMapping("/sample")
	public String getSampleResponse() {
		return "Sample Response";
	}

	@GetMapping("/receipts/{provider}/{theDate}")
	public ResponseEntity<Receipt> getReceipt(@PathVariable String provider, @PathVariable String theDate) {
		Receipt receipt = this.receiptsService.getReceipt(provider, theDate);
		return new ResponseEntity<>(new Receipt("Walmart"), HttpStatus.OK);
	}

	@GetMapping("/receipts/{provider}")
	public ResponseEntity<List<Receipt>> getReceiptByProvider(@PathVariable String provider) throws ParseException {
		List<Receipt> receipts = this.receiptsService.getReceipt(provider);
		return new ResponseEntity<>(receipts, HttpStatus.OK);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void receiptNotFoundHandler(ReceiptNotFoundException ex) {}


}
