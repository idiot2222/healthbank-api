package com.pps.recommend;

import com.pps.data.EvaluationDto;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RecommendUtil {

    public List<Long> recommend(Long userId, int recommendCount, List<EvaluationDto> evaluations) {
        try {
            FastByIDMap<PreferenceArray> recommendMap = evalsToMap(evaluations);

            DataModel model = new GenericDataModel(recommendMap);
            CityBlockSimilarity similarity = new CityBlockSimilarity(model);
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1,similarity, model);
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            return recommender.recommend(userId, recommendCount)
                    .stream()
                    .map(RecommendedItem::getItemID)
                    .collect(Collectors.toList());

        } catch (TasteException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private FastByIDMap<PreferenceArray> evalsToMap(List<EvaluationDto> evaluations) {
        Map<Long, ArrayList<GenericPreference>> tempMap = new HashMap<>();

        for (EvaluationDto x : evaluations) {
            storeToMap(tempMap, x);
        }

        FastByIDMap<PreferenceArray> map = new FastByIDMap<>();

        for (Map.Entry<Long, ArrayList<GenericPreference>> entry : tempMap.entrySet()) {
            Long key = entry.getKey();
            ArrayList<GenericPreference> value = entry.getValue();

            map.put(key, new GenericUserPreferenceArray(value));
        }

        return map;
    }

    private void storeToMap(Map<Long, ArrayList <GenericPreference>> map, EvaluationDto x) {
        long userId = x.getUserId();
        long itemId = x.getItemId();
        float rating = x.getRating();

        if(!map.containsKey(userId)) {
            map.put(userId, new ArrayList<>());
        }

        ArrayList<GenericPreference> list = map.get(userId);

        list.add(new GenericPreference(userId, itemId, rating));
    }

}
