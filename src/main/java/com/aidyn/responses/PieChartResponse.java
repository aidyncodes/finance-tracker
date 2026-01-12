package com.aidyn.responses;
import java.util.List;

public record PieChartResponse(List<String> labels, List<Double> values) {

}
