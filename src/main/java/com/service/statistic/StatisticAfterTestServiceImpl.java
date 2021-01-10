package com.service.statistic;

import com.model.Link;
import com.model.Literature;
import com.model.Statistic;
import com.model.StatisticAfterTest;
import com.service.link.LinkService;
import com.service.literature.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class StatisticAfterTestServiceImpl implements StatisticAfterService {

    private final LiteratureService literatureService;
    private final LinkService linkService;

    @Autowired
    public StatisticAfterTestServiceImpl(LiteratureService literatureService, LinkService linkService) {
        this.literatureService = literatureService;
        this.linkService = linkService;
    }

    public void getStatisticAfterTest(HttpSession session, Model model){
        List<Statistic> statistics = (List<Statistic>) session.getAttribute("statistics");
        List<StatisticAfterTest> statisticView = new ArrayList<>();
        int numOfCorrect=0;
//        Fill list of statisticView (Name of question, is correct, list of literature, list of links)
        for (Statistic statistic : statistics) {
            StatisticAfterTest pst = new StatisticAfterTest();
            pst.setNameOfQuestion(statistic.getQuestion().getDescription());
            pst.setCorrect(statistic.isCorrect());
            List<Literature> allLiteratureByQuestionId = literatureService.getAllLiteratureByQuestionId(statistic.getQuestion().getQuestionId());
            List<Link> allLinks = new ArrayList<>();
            allLiteratureByQuestionId.forEach((it)->allLinks.addAll(linkService.getAllLinkByLiteratureId(it.getLiteratureId())));
            pst.setLiterature(allLiteratureByQuestionId);
            pst.setLinkToLiterature(allLinks);
            if(statistic.isCorrect()){
                numOfCorrect++;
            }
            statisticView.add(pst);
        }
        model.addAttribute("statistics",statisticView);
        model.addAttribute("percent",Math.round(((double)numOfCorrect/statistics.size()) *100));
        model.addAttribute("numOfCorrect",numOfCorrect);
        model.addAttribute("numOfQuestion",statistics.size());
    }
}
