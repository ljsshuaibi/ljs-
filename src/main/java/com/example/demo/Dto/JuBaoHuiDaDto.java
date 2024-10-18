package com.example.demo.Dto;

import com.example.demo.entity.JuBaoHuiDa;
import lombok.Data;
@Data
public class JuBaoHuiDaDto {
        public int Status;
        public String JuBaoUserName;
        public int AnswerId;
        public String FaBuUserName;
        public String Reason;
    public JuBaoHuiDaDto(JuBaoHuiDa juBaoHuiDa,int Status){
        this.Status=Status;
        this.JuBaoUserName=juBaoHuiDa.getJuBaoUserName();
        this.AnswerId=juBaoHuiDa.getAnswerId();
        this.FaBuUserName=juBaoHuiDa.getFaBuUserName();
        this.Reason=juBaoHuiDa.getReason();
    }
}
