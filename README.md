### 参数异常处理
原先都是使用@valid + BindingResult：
``` java
    @PostMapping("/subjects")
    public CommonResult insertSubjects(@RequestBody @Valid SubjectParams subjectParams,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return CommonResult.fail(400, bindingResult.getFieldError().getDefaultMessage());
        }
        teacherSubjectService.insertSubjects(subjectParams);
        return CommonResult.success();
    }
```
现在使用同一处理参数异常（不再使用bindingResult参数）：
``` java
    @PostMapping("/subjects")
    public CommonResult insertSubjects(@RequestBody @Valid SubjectParams subjectParams){
        teacherSubjectService.insertSubjects(subjectParams);
        return CommonResult.success();
    }
```
``` java
    //处理参数异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handler(MethodArgumentNotValidException e) {
        return CommonResult.fail(400, e.getBindingResult().getFieldError().getDefaultMessage());
    }
```
RuntimeException是非受检异常，可以不用在方法中捕获。