package org.yann.icloud.zuul.aggregation;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

@RestController
@Slf4j
public class AggregationController {

    @Autowired
    private AggregationService aggregationService;

    @GetMapping(value = "/aggregate/{id}")
    public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id) {
        Observable<HashMap<String, User>> result = this.aggreateObservable(id);
        return this.toDeferredResult(result);
    }

    private Observable<HashMap<String, User>> aggreateObservable(Long id) {
        return Observable.zip(
                this.aggregationService.getUserById(id),
                this.aggregationService.getMovieUserByUserId(id),
                (user, movieUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("movieUser", movieUser);
                    return map;
                }
        );
    }


    public DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
        DeferredResult<HashMap<String, User>> result = new DeferredResult<>();
        details.subscribe(
                new Observer<HashMap<String, User>>() {
                    @Override
                    public void onCompleted() {
                        log.info("完成");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.error("发生错误");
                    }

                    @Override
                    public void onNext(HashMap<String, User> movieDetails) {
                        result.setResult(movieDetails);
                    }
                }
        );
        return result;
    }


}
