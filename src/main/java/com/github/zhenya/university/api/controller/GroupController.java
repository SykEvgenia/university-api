package com.github.zhenya.university.api.controller;

import com.github.zhenya.university.api.dto.group.CrudGroupDto;
import com.github.zhenya.university.api.dto.group.GroupDto;
import com.github.zhenya.university.api.servise.GroupService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class GroupController {

    private GroupService service;

    @GetMapping("/group")
    public List<GroupDto> getGroups() {
        return service.getGroups();
    }

    @PostMapping("/group")
    public GroupDto addGroup(@RequestBody @Valid CrudGroupDto dto) {
        return service.addGroup(dto);
    }

    @PutMapping("/group/{id}")
    public GroupDto putGroup(@PathVariable("id") @NotBlank String id, @RequestBody @Valid CrudGroupDto dto) {
        return service.putGroup(id, dto);
    }

    @DeleteMapping("/group/{id}")
    public void deleteGroup(@PathVariable("id") @NotBlank String id) {
        service.deleteGroup(id);
    }
}
