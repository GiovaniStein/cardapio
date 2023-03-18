import { useMutation, useQueryClient } from "@tanstack/react-query";
import { AxiosPromise } from "axios"
import Api from "../api/axios-config"
import { FoodData } from "../interface/FoodData";

const postData = async (data: FoodData): AxiosPromise<any> => {
    const response = Api.post('/food', data);
    return response
}

export function useFoodDataMutate() {
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries(['food-data'])
        }
    });

    return mutate;
}