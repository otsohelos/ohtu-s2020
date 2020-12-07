package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
  private Matcher m;

  public QueryBuilder() {
    this.m = new And(new All());
  }

  public Matcher build() {
    Matcher oldMatcher = m;
    reset();
    return oldMatcher;
  }

  private void reset() {
    this.m = new All();
  }

  public QueryBuilder playsIn(String string) {
    this.m = new And(new PlaysIn(string), m);
    return this;
  }

  public QueryBuilder hasAtLeast(int i, String string) {
    this.m = new And(new HasAtLeast(i, string), m);
    return this;
  }

  public QueryBuilder hasFewerThan(int i, String string) {
    this.m = new And(new HasFewerThan(i, string), m);
    return this;
  }

  public QueryBuilder oneOf(Matcher m1, Matcher m2) {
    this.m = new Or(m1, m2);
    return this;
  }
}
