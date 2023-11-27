package clayton.eduard.oulhostbackend.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clayton.eduard.oulhostbackend.model.GroupType;
import clayton.eduard.oulhostbackend.service.CodiNameService;

@Component
public class CodiNameHandler {

    @Autowired
    private CodiNameService service;

    public String findCodiname(GroupType groupType) {
        if (groupType == GroupType.AVANGERS) {
            String firstMatch = service.getAvangersCodiNameList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodiNameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = service.getJusticeLeagueList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueList().remove(firstMatch);
        return firstMatch;
    }
}
