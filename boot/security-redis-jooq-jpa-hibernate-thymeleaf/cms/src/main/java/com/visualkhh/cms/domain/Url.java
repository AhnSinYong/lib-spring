package com.visualkhh.cms.domain;

import com.visualkhh.common.domain.UrlBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter @EqualsAndHashCode(callSuper=false) @Entity @Table(name="T_URL")
public class Url extends UrlBase{
}
