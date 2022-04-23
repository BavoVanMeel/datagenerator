package datageneratorv2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum DataType {
	DATETIME("dd/dd/dddd dd:dd/dd"),
	DATE("dd/dd/dddd");
	
	private final Predicate<String> tester;
	
	DataType(String regexp) {
		tester = Pattern.compile(regexp).asPredicate();
	}
	
	public static Optional<DataType> getTypeOfField(String[] fieldValues) {
		return Arrays.stream(values())
				.filter(dt -> Arrays.stream(fieldValues).allMatch(dt.tester))
				.findFirst();
	}
}
