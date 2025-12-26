package com.hospital.management.entity;

import jakarta.persistence.*;
import lombok.Data;

public enum Department {
	GENERAL("General Medicine"),
    ENT("ENT"),
    CARDIOLOGY("Cardiology"),
    NEUROLOGY("Neurology"),
    ORTHOPEDIC("Orthopedic"),
    DERMATOLOGY("Dermatology"),
    PEDIATRICS("Pediatrics");

    private final String displayName;

    Department(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	
	
}