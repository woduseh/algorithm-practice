package practice.effectjvejava.item11;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class Apple1 extends AppleParent {
	private String color;
	private int weight;
	private LocalDateTime harvestDay;
}
