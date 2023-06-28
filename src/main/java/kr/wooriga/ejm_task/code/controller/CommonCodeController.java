package kr.wooriga.ejm_task.code.controller;

import kr.wooriga.ejm_task.code.service.CommonCodeService;
import kr.wooriga.ejm_task.common.config.Uris;
import kr.wooriga.ejm_task.common.response.BaseResponse;
import kr.wooriga.ejm_task.common.response.ResponseMapper;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
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

    @PostMapping(value = Uris.CODE_ROOT)
    public ResponseEntity<BaseResponse> createCode(@Valid @RequestBody final CommonCodePayloads.CreateRequest request) {
        service.createCode(request);
        return responseMapper.ok();
    }

    @PatchMapping(value = Uris.CODE_ROOT)
    public ResponseEntity<BaseResponse> updateCode(@Valid @RequestBody final CommonCodePayloads.UpdateRequest request) {
        service.updateCode(request);
        return responseMapper.ok();
    }

    @DeleteMapping(value = Uris.CODE_ROOT + Uris.REST_NAME_UUID)
    public ResponseEntity<BaseResponse> deleteCode(@PathVariable final String uuid) {
        service.deleteCode(uuid);
        return responseMapper.ok();
    }

    @PostMapping(value = Uris.CODE_GROUP_LIST)
    public ResponseEntity<BaseResponse> codeGroupList(@Valid @RequestBody final CommonCodeGroupPayloads.ListRequest request) {
        Page<CommonCodeGroupPayloads.ListResponse> list = service.codeGroupList(request);
        return responseMapper.ok(list);
    }

    @GetMapping(value = Uris.CODE_GROUP_ROOT + Uris.REST_NAME_UUID)
    public ResponseEntity<BaseResponse> codeGroupDetail(@PathVariable final String uuid) {
        CommonCodeGroupPayloads.DetailResponse detail = service.codeGroupDetail(uuid);
        return responseMapper.ok(detail);
    }

    @PostMapping(value = Uris.CODE_GROUP_ROOT)
    public ResponseEntity<BaseResponse> createCodeGroup(@Valid @RequestBody final CommonCodeGroupPayloads.CreateRequest request) {
        service.createCodeGroup(request);
        return responseMapper.ok();
    }

    @PatchMapping(value = Uris.CODE_GROUP_ROOT)
    public ResponseEntity<BaseResponse> updateCodeGroup(@Valid @RequestBody final CommonCodeGroupPayloads.UpdateRequest request) {
        service.updateCodeGroup(request);
        return responseMapper.ok();
    }

    @DeleteMapping(value = Uris.CODE_GROUP_ROOT + Uris.REST_NAME_UUID)
    public ResponseEntity<BaseResponse> deleteCodeGroup(@PathVariable final String uuid) {
        service.deleteCodeGroup(uuid);
        return responseMapper.ok();
    }

}
