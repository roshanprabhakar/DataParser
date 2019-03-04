public class ElectionResult {
    int votes_dem;
    int votes_gop;
    int total_votes;
    double per_dem;
    double per_gop;
    String diff;
    double perPointDiff;
    String state;
    String county_name;
    int combined_fips;

    public int getVotes_dem() {
        return votes_dem;
    }

    public void setVotes_dem(int votes_dem) {
        this.votes_dem = votes_dem;
    }

    public int getVotes_gop() {
        return votes_gop;
    }

    public void setVotes_gop(int votes_gop) {
        this.votes_gop = votes_gop;
    }

    public int getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(int total_votes) {
        this.total_votes = total_votes;
    }

    public double getPer_dem() {
        return per_dem;
    }

    public void setPer_dem(double per_dem) {
        this.per_dem = per_dem;
    }

    public double getPer_gop() {
        return per_gop;
    }

    public void setPer_gop(double per_gop) {
        this.per_gop = per_gop;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public double getPerPointDiff() {
        return perPointDiff;
    }

    public void setPerPointDiff(double perPointDiff) {
        this.perPointDiff = perPointDiff;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public int getCombined_fips() {
        return combined_fips;
    }

    public void setCombined_fips(int combined_fips) {
        this.combined_fips = combined_fips;
    }

}
