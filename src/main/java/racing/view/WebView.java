package racing.view;

import racing.domain.Car;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebView {

    private WebResult webResult;

    public String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public WebResult makeCarInfo(List<Car> cars) {
        webResult = new WebResult();

        Map<String, List<Integer>> resultMap = new HashMap<>();
        for (Car car : cars) {
            List<Integer> moves = makeCarMoveDistance(car);
            resultMap.put(car.getName(), moves);
        }

        webResult.setCars(resultMap);

        return webResult;
    }

    public List<Integer> makeCarMoveDistance(Car car) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < car.getTotalDistance(); i++) {
            moves.add(1);
        }
        return moves;
    }

    public String makeWinnerNameString(List<Car> winners) {
        String winnersName = "";
        for (Car car : winners) {
            winnersName += car.getName();
            winnersName += ",";
        }
        return winnersName.substring(0, winnersName.length() - 1);
    }
}