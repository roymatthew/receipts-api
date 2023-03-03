package edu.receitps.api;

import edu.receitps.api.dto.Receipt;
import edu.receitps.api.dto.ReceiptItem;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FakeReceiptsDB {

    public static List<Receipt> getAll() throws ParseException {
        return Stream.of(
                new Receipt("Walmart", AmountConverter.convertStringToBigDecimal("100.85"), 5, DateConverter.convertStringToDate("01/01/2005"),
                        Stream.of(new ReceiptItem("JustForMen Hair Dye", AmountConverter.convertStringToBigDecimal("10.49"))
                        , new ReceiptItem("Philips Light Bulb", AmountConverter.convertStringToBigDecimal("90.36"))).collect(Collectors.toList())),
                new Receipt("Target", AmountConverter.convertStringToBigDecimal("200.00"), 1, DateConverter.convertStringToDate("09/10/2015"),
                        Stream.of(new ReceiptItem("Xbox 360", AmountConverter.convertStringToBigDecimal("200.00"))).collect(Collectors.toList())),
                new Receipt("Kohls", AmountConverter.convertStringToBigDecimal("50.40"), 3, DateConverter.convertStringToDate("11/23/2018"),
                        Stream.of(new ReceiptItem("Nike Shoes", AmountConverter.convertStringToBigDecimal("50.40"))).collect(Collectors.toList())),
                new Receipt("Costco", AmountConverter.convertStringToBigDecimal("400.16"), 4, DateConverter.convertStringToDate("07/25/2022"),
                        Stream.of(new ReceiptItem("Wild Caught Salmon", AmountConverter.convertStringToBigDecimal("39.99")),
                                new ReceiptItem("Kitchen Aid Blender", AmountConverter.convertStringToBigDecimal("360.17"))).collect(Collectors.toList())),
                new Receipt("Sams Club", AmountConverter.convertStringToBigDecimal("70.98"), 7, DateConverter.convertStringToDate("01/01/2005"),
                        Stream.of(new ReceiptItem("Air Fryer", AmountConverter.convertStringToBigDecimal("70.98"))).collect(Collectors.toList()))
        ).collect(Collectors.toList());
    }
}
