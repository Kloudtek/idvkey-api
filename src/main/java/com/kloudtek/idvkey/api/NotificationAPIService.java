/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Interface of JAX-RS IDVKey REST API server
 */
@Path("/notifications")
public interface NotificationAPIService {
    /**
     * Get the user ref for the user authenticated with that operation id
     *
     * @param opId          Operation id
     * @return User ref
     */
    @GET
    @Path("authentication/{opId}")
    @Produces("application/json")
    @AuthenticateCustomer
    AuthenticationRequestStatus getAuthenticationStatus(@NotNull @PathParam("opId") String opId);

    /**
     * Get the user ref for the user authenticated with that operation id
     *
     * @param opId Operation id
     * @return User ref
     */
    @GET
    @Path("preidauthentication/{opId}")
    @Produces("application/json")
    @AuthenticateCustomer
    AuthenticationRequestStatus getPreIdentifiedAuthenticationStatus(@NotNull @PathParam("opId") String opId);

    @GET
    @Path("approval/{opId}")
    @AuthenticateCustomer
    @Produces("application/json")
    ApprovalRequestStatus getUserApprovalStatus(@NotNull @PathParam("opId") String opId);

    @GET
    @Path("generic/{opId}")
    @AuthenticateCustomer
    @Produces("application/json")
    GenericNotificationRequestStatus getGenericNotificationStatus(@NotNull @PathParam("opId") String opId);
}
