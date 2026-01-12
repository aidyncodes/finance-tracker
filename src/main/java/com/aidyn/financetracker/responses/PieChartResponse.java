package com.aidyn.financetracker.responses;
import java.util.List;

public record PieChartResponse(List<String> labels, List<Double> values) {

}
