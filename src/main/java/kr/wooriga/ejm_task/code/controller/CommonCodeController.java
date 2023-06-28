package kr.wooriga.ejm_task.code.controller;

import kr.wooriga.ejm_task.code.service.CommonCodeService;
import kr.wooriga.ejm_task.common.config.Uris;
import kr.wooriga.ejm_task.common.response.BaseResponse;
import kr.wooriga.ejm_task.common.response.ResponseMapper;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CommonCodeController {

    private final CommonCodeService service;

    private final ResponseMapper responseMapper;

    @PostMapping(value = Uris.CODE_LIST)
    public ResponseEntity<BaseResponse> codeList(@Valid @RequestBody final CommonCodePayloads.ListRequest request) {
        Page<CommonCodePayloads.ListResponse> list = service.codeList(request);
        return responseMapper.ok(list);
    }

    @GetMapping(value = Uris.CODE_ROOT + Uris.REST_NAME_UUID)
    public ResponseEntity<BaseResponse> codeDetail(@PathVariable final String uuid) {
        CommonCodePayloads.DetailResponse detail = service.codeDetail(uuid);
        return responseMapper.ok(detail);
    }

}
